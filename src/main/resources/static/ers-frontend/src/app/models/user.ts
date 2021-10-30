export class User {
    private id: number = 0;
    private username: string = '';
    private firstname: string = '';
    private lastName: string = '';
    private email: string = '';
    private userRole!: {
        userRoleId: number;
        userRole: string;
    };
}
