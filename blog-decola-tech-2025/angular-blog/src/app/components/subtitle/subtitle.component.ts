import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-subtitle',
  imports: [],
  templateUrl: './subtitle.component.html',
  styleUrl: './subtitle.component.css'
})
export class SubtitleComponent implements OnInit{

  @Input()
  subtitle:string = ""

  constructor(){}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

}
