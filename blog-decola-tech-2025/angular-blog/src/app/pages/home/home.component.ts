import { Component, Input, OnInit } from '@angular/core';
import { MenuTitleComponent } from "../../components/menu-title/menu-title.component";
import { BigCardComponent } from "../../components/big-card/big-card.component";
import { SmallCardComponent } from "../../components/small-card/small-card.component";
import { SubtitleComponent } from "../../components/subtitle/subtitle.component";
import { SkillsComponent } from "../../components/skills/skills.component";


@Component({
  selector: 'app-home',
  imports: [MenuTitleComponent, BigCardComponent, SmallCardComponent, SubtitleComponent, SkillsComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  constructor(){}
  ngOnInit() {
    
  }
}
