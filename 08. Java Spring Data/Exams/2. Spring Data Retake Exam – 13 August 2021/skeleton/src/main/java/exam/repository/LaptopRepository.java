package exam.repository;

import exam.model.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    boolean existsByMacAddress(String macAddress);

    //•	Extract from the database, the mac address,
    // CPU speed (to second digit after decimal point),
    // ram,
    // storage,
    // price (to second digit after decimal point) of the laptop.
    // Also, we need to show the name of the shop and the name of the town.
    //•	Order Them by the cpu speed in descending order,
    // Then by the ram in descending order,
    // then by the storage in descending order
    // and finally by the MAC Address

    List<Laptop> findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc();

//    @Query("SELECT l FROM Laptop l " +
//    " ORDER BY l.cpuSpeed DESC , l.ram DESC , l.storage DESC , l.macAddress ASC ")
//    List<Laptop> findBestLaptop();
}
