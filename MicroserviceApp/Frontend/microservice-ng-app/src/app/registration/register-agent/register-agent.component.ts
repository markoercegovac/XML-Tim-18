import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RegistrationAgentService } from 'src/app/services/registration.agent.service';
import { RegistrationAgentModel } from 'src/app/model/registration-agent.model';

@Component({
  selector: 'app-register-agent',
  templateUrl: './register-agent.component.html',
  styleUrls: ['./register-agent.component.css']
})
export class RegisterAgentComponent implements OnInit{

  registerForm: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private registrationService: RegistrationAgentService
  ) {
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      company: ['', Validators.required],
      registrationNumber: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required],
      state: ['', Validators.required],
      city: ['', Validators.required],
      street: ['', Validators.required],
      streetNumber: ['', Validators.required],
      url: ['', Validators.required]
    }, {
      validator: this.MustMatch('password', 'confirmPassword')
    });
  }

  get f() { return this.registerForm.controls; }

  onSubmit(form: FormGroup) {
    this.submitted = true;

    if (this.registerForm.valid) {
      let agent: RegistrationAgentModel = {
        city: form.value.city,
        company: form.value.company,
        email: form.value.email,
        password: form.value.password,
        registrationNumber: form.value.registrationNumber,
        state: form.value.state,
        street: form.value.street,
        streetNumber: form.value.streetNumber,
        url: form.value.url
      };

      this.registrationService.register(agent);
    }

  }


// za validaciju password i confirm password
  public MustMatch(controlName: string, matchingControlName: string) {
    return (formGroup: FormGroup) => {
      const control = formGroup.controls[controlName];
      const matchingControl = formGroup.controls[matchingControlName];

      if (matchingControl.errors && !matchingControl.errors.mustMatch) {
        // return if another validator has already found an error on the matchingControl
        return;
      }

      // set error on matchingControl if validation fails
      if (control.value !== matchingControl.value) {
        matchingControl.setErrors({mustMatch: true});
      } else {
        matchingControl.setErrors(null);
      }
    };
  }

}
