import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CarSearchComponent} from './car-search.component';

@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [
        CarSearchComponent
    ],
    exports: [
        CarSearchComponent
    ]
})
export class CarSearchModule {
}
