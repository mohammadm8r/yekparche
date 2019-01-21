function setHidden(form)
{
    form.countryPostal.value = "Other";
    if ((form.countryCode.value == "US" || form.countryCode.value == "CA") && form.postalCode.value != "") {
        form.countryPostal.value = form.countryCode.value + ":" + form.postalCode.value;
    }

    return true;
}
