package rs.pparadigme.matf.funnyclicker.utils

class Item {
    var name: String? = null
    var image: Int? = null
    var info: String? = null
    var bought: Int? = null

    constructor(name: String, image: Int, info: String, bought: Int ) {
        this.name = name
        this.image = image
        this.info = info
        this.bought = bought
    }
}