import { UserRoles } from "./userroles";

export interface ErsUser {
    userId: number,
    ersUserName: string,
    ersPassword: number,
    ersFirstName: string,
    ersLastName: string,
    ersEmail: string,
    ersUserRole: UserRoles
}
