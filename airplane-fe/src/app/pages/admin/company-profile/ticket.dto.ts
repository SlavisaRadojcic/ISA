export class TicketDTO {

    id: number;
    startingPoint: string;
    endingPoint: string;
    startingDate: Date;
    ticketPrice: number;
    discount: number;

    constructor(data?: any) {
        if (data) {
            this.id = data.id;
            this.startingPoint = data.startingPoint;
            this.endingPoint = data.endingPoint;
            this.startingDate = data.startingDate;
            this.ticketPrice = data.ticketPrice;
            this.discount = data.discount;
        }
    }

}
