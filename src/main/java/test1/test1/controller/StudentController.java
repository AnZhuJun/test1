package test1.test1.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.*;
        import test1.test1.bean.Student;
        import test1.test1.service.StudentService;

        import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public String getAllStudent(ModelMap modelMap){
        modelMap.addAttribute("students",studentService.findAll());
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
        return "admin/student";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap map){
        studentService.deleteById(id);
        List<Student> students = studentService.findAll();
        map.put("students",students);
        return "admin/student";
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
        return "admin/student";
    }
}
