var validateName = function(application) {
    return !!application.id.name;
}

var validate = function(application) {
    return validateName(JSON.parse(application))
}