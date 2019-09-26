package com.azarenka;

import org.springframework.stereotype.Controller;

/**
 * Menu  controller
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnka
 * Date 21 07 2019
 */
@Controller
public class MenuController {

   /* @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private DayService dayService;
    @Autowired
    private MealService mealService;
    @Autowired
    private MenuService menuService;

    private final static Logger LOGGER = LoggerFactory.getLogger(MenuController.class);*/

   /* @GetMapping(value = "/to-create")
    public String getFoods(Model model) {
        List<MenuResponse> menu = menuService.getMenu();
        model.addAttribute("menus", menu);
        model.addAttribute("foods", foodService.getFoods());
        model.addAttribute("days", dayService.getAll());
        model.addAttribute("meals", mealService.getAll());
        model.addAttribute("login", userService.getUserName());
        model.addAttribute("menu", menu.stream().map(MenuResponse::getSetTitle)
                .distinct().collect(Collectors.toList()));
        return "create_menu";
    }

    @PostMapping(value = "/addFoodToMenu")
    public String saveToMenu(@RequestParam(required = false) @PathVariable("foodId") String foodId,
                             @RequestParam(required = false) @PathVariable("dayId") String dayId,
                             @RequestParam(required = false) @PathVariable("mealId") String mealId,
                             @RequestParam(required = false) @PathVariable("count") int count,
                             @RequestParam(required = false) @PathVariable("setTitle") String setTitle) {
        menuService.createMenu(foodId, dayId, mealId, count, setTitle);
        return "redirect:/to-create";
    }

    @PostMapping(value = "/remove/{id}")
    public String remove(@PathVariable("id") String id) {
        menuService.remove(id);
        return "redirect:/to-create";
    }*/
}
