package league

class Conference {

    String conferenceName

    static belongsTo = League
    static hasMany = [teams:Team]

    static constraints = {

        conferenceName blank:false, unique:true
    }
}
