import { Address } from "./Address";
export class Persons
{

    constructor(private _firstName:string, private _lastName:string, private _email:string, private _address:Address) {
    }

    get address(): Address {
        return this._address;
    }

    set address(value: Address) {
        this._address = value;
    }

    get firstName(): string {
        return this._firstName;
    }

    set firstName(value: string) {
        this._firstName = value;
    }

    get lastName(): string {
        return this._lastName;
    }

    set lastName(value: string) {
        this._lastName = value;
    }

    get email(): string {
        return this._email;
    }

    set email(value: string) {
        this._email = value;
    }

    getDetails(): string {
        return 'First Name: '+this._firstName+' \nLast Name: '+this._lastName+' \nEmail: '+this._email+
            ' \nAddress Line 1: '+this.address.addressLine1+' \nAddress Line 2: '+this.address.addressLine2+' \nCity: '+this._address.city;
    }
}