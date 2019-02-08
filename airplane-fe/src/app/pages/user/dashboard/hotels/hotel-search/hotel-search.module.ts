import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HotelSearchComponent} from './hotel-search.component';

@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [HotelSearchComponent],
    exports: [HotelSearchComponent]
})
export class HotelSearchModule {
}
