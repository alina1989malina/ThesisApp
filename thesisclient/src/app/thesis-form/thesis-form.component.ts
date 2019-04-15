import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ThesisService } from '../service/thesis.service';
import { Thesis } from '../model/thesis';
 
@Component({
  selector: 'app-thesis-form',
  templateUrl: './thesis-form.component.html',
  styleUrls: ['./thesis-form.component.css']
})
export class ThesisFormComponent {
 
  thesis: Thesis;
 
  constructor(private route: ActivatedRoute, private router: Router, private thesisService: ThesisService) {
    this.thesis = new Thesis();
  }
 
  onSubmit() {
    this.thesisService.save(this.thesis).subscribe(result => this.gotoThesisList());
  }
 
  gotoThesisList() {
    this.router.navigate(['/theses']);
  }
}