package sg.edu.iss.team1.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team1.model.Supplier;

public interface SupplierService {

	ArrayList<Supplier> findallSupplier();

	Supplier findSupplier(int supplierID);

	Supplier createSupplier(Supplier m);

	Supplier changeSupplier(Supplier m);

	void removeSupplier(Supplier m);

}