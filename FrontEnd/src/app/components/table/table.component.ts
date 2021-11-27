import { Component, Input, OnInit } from '@angular/core';
import { Reimb } from 'src/app/models/reimb';
import { ReimbStatus } from 'src/app/models/reimb-status';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
JSON: any;
@Input() cols!:string[];
@Input() data!:Reimb[];
reimbStatus!: ReimbStatus;
key!: string;


  constructor() { 
    
  }

  ngOnInit(): void {
  }

}
