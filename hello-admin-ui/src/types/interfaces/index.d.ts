export interface IPair<L, R> {
  left: L;
  right: R;
}

export interface ITriple<L, M, R> extends IPair<L, R> {
  middle: M;
}

export interface ISetting {
  mainLayout: {
    drawerLeftIsShow: boolean;
    drawerRightIsShow: boolean;
  };
}
