package search.back.service;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import search.back.domain.SearchDomain;
import search.back.domain.SearchPageDomain;
import search.back.model.Search;
import search.back.model.User;
import search.back.repository.SearchRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private UserService userService;

    public void add(SearchDomain searchDomain){
        Search search = new Search()
                .setContent(searchDomain.getConternt())
                .setUser(searchDomain.getUser())
                .setCreateDate(new Date().getTime());
        if (!search.getContent().equals("")){

            if (duplicateValidation(search)){
                searchRepository.save(search);

            } else {
                Optional<User> dbUser = userService.getOne(searchDomain.getUser().getId());
                dbUser.ifPresent(user -> {
                    search.setUser(user);
                    if (contentValidation(search, user))
                        searchRepository.save(search);
                });
            }
        }
    }

    private boolean contentValidation(Search search, User user){
        List<Search> searches = searchRepository.findByUser(user);
        for (Search dbSearch : searches) {
            if (search.getContent().equals(dbSearch.getContent())){
                return false;
            }
        }
        return true;
    }

    private boolean duplicateValidation(Search search){
        List<Search> searches = getAll();
        for (Search dbSearch : searches) {
            if (search.getUser().getId() == dbSearch.getUser().getId()){
                return false;
            }
        }
        return true;
    }

    public List<Search> getAll(){
        return (List<Search>) searchRepository.findAll();
    }

    public Optional<Search> getOne(long id){
        return searchRepository.findById(id);
    }

    public Page<Search> getSearchPage(long id){
        User user = userService.getOne(id).orElseThrow(WrongArgumentException::new);
        Page<Search> page;
        page = searchRepository.findByUser(user, PageRequest.of(0, 5, Sort.by("createDate").descending()));
        return page;
    }

}
