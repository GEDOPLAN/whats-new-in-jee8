package de.gedoplan.whatsnewinjee8.jpa;

import de.gedoplan.whatsnewinjee8.entity.Countries;
import de.gedoplan.whatsnewinjee8.entity.Country;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test der Persistence-Fuktionalität bzgl. der Entity Country.
 *
 * @author dw
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryTest extends JpaTestBase {
  public static Country[] testCountries = { Countries.CA, Countries.CN, Countries.DE, Countries.IT, Countries.US, Countries.VN, Countries.YU };
  public static Country[] testCountriesAS = { Countries.CN, Countries.VN };

  @Test
  public void test_00_clearData() {
    this.log.info("----- test_00_clearData -----");

    this.entityManager.createQuery("delete from Country x").executeUpdate();
  }

  @Test
  public void test_01_insertData() throws Exception {
    this.log.info("----- test_01_insertData -----");

    for (Country country : testCountries) {
      this.entityManager.persist(country);

      this.log.debug("Inserted: " + country);
    }
  }

  /**
   * Test: Finden eines Einzeleintrags anhand seiner ID.
   */
  @Test
  public void test_02_findById() {
    this.log.debug("----- test_02_findById -----");

    Country testCountry = Countries.IT;
    String id = testCountry.getId();

    Country country = this.entityManager.find(Country.class, id);

    this.log.info("Found: " + country);
  }
}
