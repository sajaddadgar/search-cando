package search.back.service;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import search.back.domain.SearchDomain;
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

    private void checkValidation(SearchDomain searchDomain, User user){
        Search search = new Search()
                .setContent(searchDomain.getContent())
                .setUser(user)
                .setCreateDate(new Date().getTime());
        if (!search.getContent().equals("")){

            if (duplicateValidation(search)){
                searchRepository.save(search);

            } else {
                Optional<User> dbUser = userService.getOne(user.getId());
                dbUser.ifPresent(user2 -> {
                    search.setUser(user2);
                    if (contentValidation(search, user2))
                        searchRepository.save(search);
                });
            }
        }
    }

    public void add(SearchDomain searchUserDomain){

        if (userService.getUserByEmail(searchUserDomain.getEmail()) != null){
            User user2 = userService.getUserByEmail(searchUserDomain.getEmail());
            checkValidation(searchUserDomain, user2);

        } else {
            User user1 = new User(searchUserDomain.getId(), searchUserDomain.getEmail());
            checkValidation(searchUserDomain, user1);
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

    public Page<Search> getSearchPage(String email){
        User user = userService.getUserByEmail(email);
        Page<Search> page;
        page = searchRepository.findByUser(user, PageRequest.of(0, 5, Sort.by("createDate").descending()));
        return page;
    }

}
