import"./chunk-6UMNZMOU.js";import{a as F,c as P,d as w,e as E}from"./chunk-H5SHBJZH.js";import{B as s,C as n,D as g,Ga as C,Na as M,Wa as S,aa as u,ea as h,g as a,j as c,k as d,pa as v,sa as y,t as m,u as f,y as l,z as r}from"./chunk-ESGM5Y7L.js";import"./chunk-MON7YFGF.js";function b(e,t){if(e&1&&(s(0,"div",5),g(1,"app-post",6),n()),e&2){let p=t.$implicit;m(),r("canEdit",!1)("post",p)}}function D(e,t){if(e&1&&(s(0,"div",3),l(1,b,2,2,"div",4),n()),e&2){let p=t.$implicit;m(),r("ngForOf",p)}}var _=(()=>{let t=class t{constructor(o){this.postService=o,this.posts=[],this.post={},this.isVisible=!1,this.isEditable=!1}ngOnInit(){this.getPosts()}getPosts(){this.postService.getAllPosts().subscribe({next:o=>{this.posts=o,console.log(this.posts)},error:o=>{console.log(o)}})}};t.\u0275fac=function(i){return new(i||t)(f(F))},t.\u0275cmp=c({type:t,selectors:[["app-feed"]],decls:3,vars:4,consts:[["dv",""],[3,"value","layout","rows","paginator"],["pTemplate","grid"],[1,"grid","grid-nogutter"],["class","col-12 sm:col-12 lg:col-6 md:col-6 xl:col-4 p-2",4,"ngFor","ngForOf"],[1,"col-12","sm:col-12","lg:col-6","md:col-6","xl:col-4","p-2"],[3,"canEdit","post"]],template:function(i,x){i&1&&(s(0,"p-dataView",1,0),l(2,D,2,1,"ng-template",2),n()),i&2&&r("value",x.posts)("layout","grid")("rows",10)("paginator",!0)},dependencies:[P,u,y,M]});let e=t;return e})();var N=[{path:"",component:_},{path:"posts",children:[{path:":id",component:w}]}],L=(()=>{let t=class t{};t.\u0275fac=function(i){return new(i||t)},t.\u0275mod=d({type:t}),t.\u0275inj=a({imports:[E,h,S,C,v.forChild(N)]});let e=t;return e})();export{L as UserModule};