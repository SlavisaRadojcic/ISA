import {DestinationDTO} from "./destination.dto";

export class CompanyProfileDTO {

    id: number;
    name: string;
    address: string;
    promoDescription: string;
    avrageRate: number;
    destinations: DestinationDTO[];
    luggageInfo: string;
    luggagePricing: string;

    constructor(data?: any) {
        if (data) {
            this.id = data.id;
            this.name = data.name;
            this.address = data.address;
            this.promoDescription = data.promoDescription;
            this.avrageRate = data.avrageRate;
            this.destinations = data.destinations;
            this.luggageInfo = data.luggageInfo;
            this.luggagePricing = data.luggagePricing;
        }
    }

}
