package com.liyang.helloadmin.framework.security.manager;

import com.liyang.helloadmin.framework.security.util.AuthenticationUtil;
import com.liyang.helloadmin.framework.security.util.AuthorizationUtil;
import com.liyang.helloadmin.framework.web.request.util.RequestUtil;
import java.util.function.Supplier;
import lombok.val;
import org.springframework.lang.NonNull;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public class AuthorizationManagerImpl implements AuthorizationManager<RequestAuthorizationContext> {

    @Override
    public AuthorizationDecision check(
        @NonNull Supplier<Authentication> authenticationSupplier,
        @NonNull RequestAuthorizationContext context
    ) {
        val request = context.getRequest();
        val jwt = RequestUtil.getAuthorizationJwt(request);
        AuthenticationUtil.authenticate(jwt);
        val authorized = AuthorizationUtil.authorize(request);
        return new AuthorizationDecision(authorized);
    }
}
