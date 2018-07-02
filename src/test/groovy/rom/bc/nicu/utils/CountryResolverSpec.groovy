package rom.bc.nicu.utils

import spock.lang.Specification
import spock.lang.Unroll

class CountryResolverSpec extends Specification {

    def "list should contain #number countries"() {
        expect:
            number == CountryResolver.getListOfCountries().size()
        where:
            number << 250
    }

    @Unroll
    def "should return #result for country #country"() {
        expect:
            result == CountryResolver.isValidCountry(country)
        where:
            result | country
            false  | null
            false  | 'Fake'
            true   | 'Romania'
    }
}
