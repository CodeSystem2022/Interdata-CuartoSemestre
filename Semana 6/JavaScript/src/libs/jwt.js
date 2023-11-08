import jwt from 'jsonwebtoken';
//Crear el token
export const createAccessToken = (payload) => {
    return new Promise((resolve, reject)=>{
        jwt.sign(payload, "xyz123",{expiresIn: "id"}),
        (err, token)=>{
            if(err) reject(err);
            resolve(token);
        };
    });
};
