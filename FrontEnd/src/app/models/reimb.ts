import { ErsUser } from "./ersUser";
import { ReimbStatus } from "./reimb-status";
import { ReimbType } from "./reimb-type";

export interface Reimb {
        reimbId: number,
        reimbAmount: number,
        reimbSubmitted: Date,
        reimbResolved: Date,
        reimbReceipt: any,
        reimbDescription: string,
        reimbAuthor: ErsUser,
        reimbResolver: ErsUser,
        reimbStatusId: ReimbStatus,
        reimbTypeId: ReimbType
}
