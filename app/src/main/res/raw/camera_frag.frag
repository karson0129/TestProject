//片元着色器
#extension GL_OES_EGL_image_external : require

precision mediump float;//数据精度

varying vec2 aCoord;

uniform samplerExternalOES vTexture; // 图片，采样器

void main(){
//    gl_FragColor = vec4(1.,1.,1.,1.);// rgba
//    gl_FragColor = texture2D(vTexture.aCoord);

    // texture2D vTexture采样器 ，采样acrood 这个像素点的RGBA值
    vec4 rgba = texture2D(vTexture,aCoord);  //rgba
    gl_FragColor = vec4(1.-rgba.r,1.-rgba.g,1.-rgba.b,rgba.a);
}
