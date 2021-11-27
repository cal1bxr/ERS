import { convertPropertyBindingBuiltins } from '@angular/compiler/src/compiler_util/expression_converter';
import { Component, OnInit } from '@angular/core';
import { Reimb } from 'src/app/models/reimb';
import { ReimbsService } from 'src/app/services/reimbs.service';

@Component({
  selector: 'app-reimbs',
  templateUrl: './reimbs.component.html',
  styleUrls: ['./reimbs.component.css']
})
export class ReimbsComponent implements OnInit {

  constructor(private reimbService: ReimbsService) { }

  cols!: string[];
  tableData: Reimb[]= [];
  data: Reimb[] = [];

  ngOnInit(): void {
    this.getReimbs()
  }

  getReimbs(){
    this.reimbService.getReimbursements().subscribe(response=>{
      if(Array.isArray(response)){
        this.data = response;
        console.log(this.data);
        this.cols=Object.keys(response[0]);
        console.log(this.data[0].reimbStatusId);
      }
    },
    err=>{console.log(err);},
    ()=>{this.tableData=this.data; console.log(this.tableData[0].reimbId); console.log(typeof this.tableData)}
    )
  }
}
