export class Announcement {
    id: number;
    owner: {
        id: number,
        firstName: string,
        lastName: string,
        email: string,
        phoneNumber: string,
    };
    realEstate: {
        id: number,
        area: number,
        roomNumber: number,
        type: {
            id: number,
            name: string
        },
        zone: {
            id: number,
            name: string,
            postalCode: number,
            latitude: number,
            longitude: number,
            wastePollution: number,
            chimicPollution: number,
            noisePollution: number,
            shopsNearby: boolean,
            entertainmentNearby: boolean,
            barsNearby: boolean,
            publicTransportNearby: boolean,
            greatView: boolean,
            parking: boolean,
            hardReachable: boolean
        }
    };
    name: string;
    description: string;
    price: number;
    viewNumber: number;
    postDate: string;
    expireDate: string;

    constructor() {
        this.owner = {
            id: 0,
            firstName: "",
            lastName: "",
            email: "",
            phoneNumber: "",
        };
        this.realEstate = {
            id: 0,
            area: 0,
            roomNumber: 0,
            type: {
                id: 0,
                name: ""
            },
            zone: {
                id: 0,
                name: "",
                postalCode: 0,
                latitude: 0,
                longitude: 0,
                wastePollution: 0,
                chimicPollution: 0,
                noisePollution: 0,
                shopsNearby: false,
                entertainmentNearby: false,
                barsNearby: false,
                publicTransportNearby: false,
                greatView: false,
                parking: false,
                hardReachable: false
            }
        };
    }
}