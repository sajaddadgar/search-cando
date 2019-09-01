package search.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import search.back.domain.SearchInfoDomain;
import search.back.domain.SearchPageDomain;
import search.back.domain.SearchDomain;
import search.back.model.Search;
import search.back.service.SearchService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    /*@PostMapping("/add")
    public void add(@RequestBody SearchDomain searchDomain){
        searchService.add(searchDomain);
    }*/

    @PostMapping("/add")
    public void add(@RequestBody SearchDomain searchUserDomain){
        searchService.add(searchUserDomain);
    }

    @PostMapping("/page/{id}")
    public SearchPageDomain getSearchPage(@PathVariable long id){
        Page<Search> domain = searchService.getSearchPage(id);
        Page<SearchInfoDomain> map = domain.map(SearchInfoDomain::new);
        return new SearchPageDomain(map.get().collect(Collectors.toList()), map.getTotalElements(), map.getTotalPages());
    }
}