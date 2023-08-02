export class Address
{
    constructor(private _addressLine1:string, private _addressLine2:string, private _city:string) {
    }


    get addressLine1(): string {
        return this._addressLine1;
    }

    set addressLine1(value: string) {
        this._addressLine1 = value;
    }

    get addressLine2(): string {
        return this._addressLine2;
    }

    set addressLine2(value: string) {
        this._addressLine2 = value;
    }

    get city(): string {
        return this._city;
    }

    set city(value: string) {
        this._city = value;
    }
}