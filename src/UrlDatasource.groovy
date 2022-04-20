def company_bedding = ['Deslee Mattex', 'Namib Foam', 'Restonic', 'Vitafoam', 'Sleepgroup']
def company_default = ['Connacher', 'Vitatex', 'Fairtech']

String company = company

if (company == null){
    return []
}

if (company.equalsIgnoreCase('Bedding') ) {
    return company_bedding
} else {
    return company_default
}