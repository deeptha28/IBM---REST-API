import {Department} from "./Department";

export class Employee
{
    constructor(private firstName:string, private lastName:string, private department:Department) {
    }
    public getDetails():string
    {
        return 'FirstName: '+this.firstName+' LastName: '+this.lastName+ ' Department: '+this.department.departmentName;
    }
}