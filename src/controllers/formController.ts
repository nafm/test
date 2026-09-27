import { Request, Response, NextFunction } from 'express';
import { z } from 'zod';

const formSchema = z.object({
  name: z.string().min(1, "Le nom est requis"),
  email: z.string().email("Format d'email invalide")
});

export const submitForm = async (req: Request, res: Response, next: NextFunction) => {
  try {
    const validatedData = formSchema.safeParse(req.body);

    if (!validatedData.success) {
      return res.status(422).json({
        error: "Validation échouée",
        details: validatedData.error.errors
      });
    }

    // Traitement de la soumission...
    res.status(200).json({ message: "Succès" });
  } catch (error) {
    next(error);
  }
};

export const validateData = (data: any) => {
  return formSchema.safeParse(data);
};