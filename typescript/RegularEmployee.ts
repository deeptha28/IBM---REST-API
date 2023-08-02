import {Employee} from "./Employee";
import {Department} from "./Department";

export class RegularEmployee extends Employee
{
    private salary:number;

    constructor(firstName: string, lastName: string, department: Department, salary: number) {
        super(firstName, lastName, department);
        this.salary = salary;
    }

    public getDetails(): string {
        return super.getDetails()+' Salary: '+this.salary;
    }
}