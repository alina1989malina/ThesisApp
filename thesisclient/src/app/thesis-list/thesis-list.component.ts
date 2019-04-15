import { Component, OnInit } from '@angular/core';
import { Thesis } from '../model/thesis';
import { ThesisService } from '../service/thesis.service';
 
@Component({
  selector: 'app-thesis-list',
  templateUrl: './thesis-list.component.html',
  styleUrls: ['./thesis-list.component.css']
})
export class ThesisListComponent implements OnInit {
 
  theses: Thesis[];
 
  constructor(private thesisService: ThesisService) {
  }
 
  ngOnInit() {
    this.thesisService.findAll().subscribe(data => {
      this.theses = data;
    });
  }
}
