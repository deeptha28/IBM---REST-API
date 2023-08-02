class Person
{
    private _firstName:string;
    private _lastName:string;
    private _email:string;

    constructor(firstName: string, lastName: string, email: string)
    {
        this._firstName = firstName;
        this._lastName = lastName;
        this._email = email;
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
        return 'First Name: '+this._firstName+' \nLast Name: '+this._lastName+' \nEmail: '+this._email;
    }
}

let person = new Person("Natasha","Romonoff","romNat@starks.inc");
console.log(person.getDetails());
person.firstName="Robert";
console.log(person.firstName);
console.log(person.lastName);