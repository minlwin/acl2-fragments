package com.jdc.relationships.model.vo

import com.jdc.relationships.model.entity.Section
import java.util.*

data class RegistrationVO(
    var id:Int?,
    var doctor:String?,
    var patient:String?,
    var registDate:Date?,
    var section:Section?,
    var token:Int?
)