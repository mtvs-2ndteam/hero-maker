export default class Player{

    _nickName = "쿠크냐";
    _hp = 0;
    _str = 0;
    _mage = 0;
    _weaponPoint = 0;
    _reputation = 0;
    _day = 1;


    get day() {
        return this._day;
    }

    set day(value) {
        this._day = value;
    }

    get nickName() {
        return this._nickName;
    }

    set nickName(value) {
        this._nickName = value;
    }

    get hp() {
        return this._hp;
    }

    set hp(value) {
        this._hp = value;
    }

    get str() {
        return this._str;
    }

    set str(value) {
        this._str = value;
    }

    get mage() {
        return this._mage;
    }

    set mage(value) {
        this._mage = value;
    }

    get weaponPoint() {
        return this._weaponPoint;
    }

    set weaponPoint(value) {
        this._weaponPoint = value;
    }

    get reputation() {
        return this._reputation;
    }

    set reputation(value) {
        this._reputation = value;
    }
}