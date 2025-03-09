import { Component } from "@angular/core"
import { MenuTitleComponent } from "./components/menu-title/menu-title.component"
import { MenuBarComponent } from "./components/menu-bar/menu-bar.component"
import { SmallCardComponent } from "./components/small-card/small-card.component"
import { IconComponent } from "./components/icon/icon.component"

@Component({
  selector: "app-root",
  standalone: true,
  imports: [MenuTitleComponent,
            MenuBarComponent,
            SmallCardComponent,
            IconComponent], 
  template: `
    <div>
      <app-menu-bar></app-menu-bar>
      <main>
        <h1>Meu Aplicativo Angular</h1>
        <!-- Outro conteúdo -->
      </main>
    </div>
  `,
  styleUrl: "./app.component.css",
})
export class AppComponent {
  title = "angular-app"
}