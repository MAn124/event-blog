import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { ButtonModule } from 'primeng/button';
import { SidebarModule } from 'primeng/sidebar';
import { TableModule } from 'primeng/table';
import { DropdownModule } from "primeng/dropdown";
import { InputTextModule } from "primeng/inputtext";
import { DialogModule } from 'primeng/dialog';
import { SelectButtonModule } from 'primeng/selectbutton';
import { ToastModule } from 'primeng/toast';
import { DataViewModule } from 'primeng/dataview';
import { ChipsModule } from 'primeng/chips';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { TagModule } from 'primeng/tag';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
@NgModule({
    declarations:[],
    exports:[ButtonModule,
        SidebarModule,
        TableModule,
        DropdownModule,
        InputTextModule,
        DialogModule,
        SelectButtonModule,
        ToastModule,
        DataViewModule,
        ChipsModule,
        InputTextModule,
        TagModule,
        ConfirmDialogModule
    ]
})
export class PrimeNgModule {

}