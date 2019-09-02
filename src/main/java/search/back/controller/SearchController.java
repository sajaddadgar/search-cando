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

    @PostMapping("/add")
    public void add(@RequestBody SearchDomain searchUserDomain){
        searchService.add(searchUserDomain);
    }

    @PostMapping("/page/{email}")
    public SearchPageDomain getSearchPage(@PathVariable String email){
        Page<Search> domain = searchService.getSearchPage(email);
        Page<SearchInfoDomain> map = domain.map(SearchInfoDomain::new);
        return new SearchPageDomain(map.get().collect(Collectors.toList()), map.getTotalElements(), map.getTotalPages());
    }
}