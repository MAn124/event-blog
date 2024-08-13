export interface User {
     id?: string;
     lastName?: string;
     firstName?: string;
     email?: string;
     username?: string;
     password?: string;
     active?:boolean;
     role?: number;
     createAt?: string;
}
