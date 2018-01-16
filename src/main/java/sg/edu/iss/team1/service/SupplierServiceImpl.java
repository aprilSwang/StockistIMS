
package sg.edu.iss.team1.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team1.model.Supplier;
import sg.edu.iss.team1.repository.SupplierRepository;


@Service
 public class SupplierServiceImpl implements SupplierService  {

	@Resource
	SupplierRepository srepo;


	/* (non-Javadoc)
	 * @see sg.edu.iss.team1.service.SupplierService#findallSupplier()
	 */
	@Override
	@Transactional
	public ArrayList<Supplier> findallSupplier() {
		ArrayList<Supplier> l = (ArrayList<Supplier>) srepo.findAll();
		return l;
	}

	/* (non-Javadoc)
	 * @see sg.edu.iss.team1.service.SupplierService#findSupplier(int)
	 */
	@Override
	@Transactional
	public Supplier findSupplier (int supplierID) {
		return srepo.findOne(supplierID);
	}

	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team1.service.SupplierService#createSupplier(sg.edu.iss.team1.model.Supplier)
	 */
	@Override
	@Transactional
	public Supplier createSupplier (Supplier m) {
	return srepo.saveAndFlush(m);
	}
    

	/* (non-Javadoc)
	 * @see sg.edu.iss.team1.service.SupplierService#changeSupplier(sg.edu.iss.team1.model.Supplier)
	 */
	@Override
	@Transactional
	public Supplier changeSupplier(Supplier m) {
	return srepo.saveAndFlush(m);
	}


	/* (non-Javadoc)
	 * @see sg.edu.iss.team1.service.SupplierService#removeSupplier(sg.edu.iss.team1.model.Supplier)
	 */
	@Override
	@Transactional
	public void removeSupplier (Supplier m) {
	srepo.delete(m);
	}
}
