import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-skills',
  imports: [],
  templateUrl: './skills.component.html',
  styleUrl: './skills.component.css'
})
export class SkillsComponent implements OnInit {

    @Input()
    photoCover:string = ""

    constructor(){}

    ngOnInit(): void {
      
    }
  
}
