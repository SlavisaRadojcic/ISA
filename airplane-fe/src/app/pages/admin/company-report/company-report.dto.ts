
export class CompanyReportDTO {

    id: number;
    name: string;
    address: string;
    promoDescription: string;
    avrageRate: number;
    luggageInfo: string;
    luggagePricing: string;

    constructor(data?: any) {
        if (data) {
            this.id = data.id;
            this.name = data.name;
            this.address = data.address;
            this.promoDescription = data.promoDescription;
            this.avrageRate = data.avrageRate;
            this.luggageInfo = data.luggageInfo;
            this.luggagePricing = data.luggagePricing;
        }
    }

}
