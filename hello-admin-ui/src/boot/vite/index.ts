const mainPages = import.meta.glob("/src/pages/main/**/*.vue");

export function importMainPage(component: string) {
  // Test
  /*for (const path in mainPages) {
    mainPages[path]().then((mod) => {
      console.log(path, mod);
    });
  }*/
  // component = '/src/pages/main/HomePage.vue'
  return () => mainPages[component]();
}
