import { ErsUser } from "./ersUser";
import { ReimbStatus } from "./reimb-status";
import { ReimbType } from "./reimb-type";

export class Reimb {
    constructor(
        reimbId: number,
        reimbAmount: number,
        reimbSubmitted: Date,
        reimbResolved: Date,
        reimbAuthor: ErsUser,
        reimbResolver: ErsUser,
        reimbStatus: ReimbStatus,
        reimbType: ReimbType
    ){}
}
