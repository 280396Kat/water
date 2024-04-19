package ru.it2g.h2o.service;

import ru.it2g.h2o.dto.CatalogFilter;

import java.util.List;

public interface ProductService {

    List<?> getInfoCatalogByFilter(CatalogFilter catalogFilter);
}
