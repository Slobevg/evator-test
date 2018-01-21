var validateName = function(whitish) {
    return !!whitish.name;
}

var validate = function(whitish) {
    return validateName(JSON.parse(whitish))
}