package league

class Season {

    String seasonName
    Date seasonStart
    Date seasonEnd

    League league

    static constraints = {

        seasonName blank:false, unique:true
        seasonStart blank:false
        seasonEnd blank:false
    }

}
