package test1.test1.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.domain.Sort;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.*;
        import test1.test1.bean.Class;
        import test1.test1.bean.Student;
        import test1.test1.bean.Teacher;
        import test1.test1.service.StudentService;

        import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public String getAllStudent(ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"studentid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<Student> students = studentService.findAll(pageable);

        modelMap.addAttribute("students",students);
        return "admin/student";
    }

    @PostMapping("/student")
    public String addAndGetStudent(String name,String classs,String department,ModelMap modelMap){
        Student student = new Student();
        student.setName(name);
        student.setClasss(classs);
        student.setDepartment(department);
        studentService.addStudent(student);

        List<Student> students = studentService.findAll();
        modelMap.put("students",students);
        return "admin/common/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap map){
        studentService.deleteById(id);
        List<Student> students = studentService.findAll();
        map.put("students",students);
        return "admin/common/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        Student da = studentService.getById(id);
        modelMap.addAttribute("da",da);
        return "admin/editStudent";
    }

    @PutMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id){
        return studentService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(Student student,ModelMap map){
        student.setStudentid(student.getStudentid());
        studentService.addStudent(student);
        List<Student> students = studentService.findAll();
        map.put("students",students);
        return "admin/common/adminNavigator";
    }

    @RequestMapping("/search")
    public String search(int studentid,ModelMap modelMap){
        Student sst = studentService.getById(studentid);
        modelMap.addAttribute("sst",sst);
        return "admin/searchStudent";
    }
}
